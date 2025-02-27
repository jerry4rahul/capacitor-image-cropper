import { WebPlugin } from '@capacitor/core';

import type { CropOptions, CropResult, ImageCropperPlugin } from './definitions';

export class ImageCropperWeb extends WebPlugin implements ImageCropperPlugin {
  async crop(options: CropOptions): Promise<CropResult> {
    return {
      path: options.source,
    };
  }
}
