import { WebPlugin } from '@capacitor/core';

import type { CropOptions, CropResult, ImageCropperPlugin } from './definitions';

export declare class ImageCropper extends WebPlugin implements ImageCropperPlugin {
  crop(options: CropOptions): Promise<CropResult>;
}
