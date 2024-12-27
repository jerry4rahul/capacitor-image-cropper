import { WebPlugin } from '@capacitor/core';

import type { ImageCropperPlugin } from './definitions';

export class ImageCropperWeb extends WebPlugin implements ImageCropperPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
