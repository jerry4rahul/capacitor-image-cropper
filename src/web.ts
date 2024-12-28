import { WebPlugin } from '@capacitor/core';

import type { CropOptions, CropResult, ImageCropperPlugin } from './definitions';

export class ImageCropperWeb extends WebPlugin implements ImageCropperPlugin {
  crop(options: CropOptions): Promise<CropResult> {
    throw new Error('Method not implemented.');
  }
}
