import { registerPlugin } from '@capacitor/core';

import type { ImageCropperPlugin } from './definitions';

const ImageCropper = registerPlugin<ImageCropperPlugin>('ImageCropper');

export * from './definitions';
export { ImageCropper };
