package in.emptycode.imagecropper;

import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.yalantis.ucrop.UCrop;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

@CapacitorPlugin(name = "ImageCropper")
public class ImageCropperPlugin extends Plugin {
    private PluginCall savedCall;
    private final ActivityResultLauncher<Intent> cropLauncher;

    public ImageCropperPlugin() {
        cropLauncher = getActivity().registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> handleCropResult(result));
    }

    @PluginMethod
    public void crop(PluginCall call) {
        try {
            String sourcePath = call.getString("source");
            Uri sourceUri = Uri.parse(sourcePath);
            Uri destinationUri = createDestinationUri();

            UCrop uCrop = configureUCrop(sourceUri, destinationUri, call);
            savedCall = call;
            cropLauncher.launch(uCrop.getIntent(getContext()));
        } catch (Exception e) {
            call.reject("Failed to crop image", e);
        }
    }

    private Uri createDestinationUri() {
        return Uri.parse("file://" + getContext().getCacheDir().getAbsolutePath() +
                "/cropped_" + System.currentTimeMillis() + ".jpg");
    }

    private UCrop configureUCrop(Uri sourceUri, Uri destinationUri, PluginCall call) {
        UCrop.Options options = new UCrop.Options();
        options.setCompressionQuality(call.getInt("quality", 100));

        UCrop uCrop = UCrop.of(sourceUri, destinationUri);

        int width = call.getInt("width", 0);
        int height = call.getInt("height", 0);
        if (width > 0 && height > 0) {
            uCrop.withMaxResultSize(width, height);
        }

        float aspectRatio = call.getFloat("aspectRatio", 0f);
        if (aspectRatio > 0) {
            uCrop.withAspectRatio(aspectRatio, 1);
        }

        uCrop.withOptions(options);
        return uCrop;
    }

    private void handleCropResult(ActivityResult result) {
        if (savedCall == null) {
            return;
        }

        try {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Uri resultUri = UCrop.getOutput(result.getData());
                JSObject jsResult = new JSObject();
                jsResult.put("path", resultUri.toString());
                savedCall.resolve(jsResult);
            } else if (result.getResultCode() == UCrop.RESULT_ERROR) {
                Throwable cropError = UCrop.getError(result.getData());
                savedCall.reject("Failed to crop image: " + cropError.getMessage());
            } else {
                savedCall.reject("User cancelled");
            }
        } finally {
            savedCall = null;
        }
    }
}