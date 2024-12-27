import { registerPlugin } from '@capacitor/core';

import type { ImageCropperPlugin } from './definitions';

const ImageCropper = registerPlugin<ImageCropperPlugin>('ImageCropper', {
  web: () => import('./web').then((m) => new m.ImageCropperWeb()),
});

export * from './definitions';
export { ImageCropper };
