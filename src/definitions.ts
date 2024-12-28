export interface ImageCropperPlugin {
  crop(options: CropOptions): Promise<CropResult>;
}

export interface CropOptions {
  source: string;
  quality?: number;
  width?: number;
  height?: number;
  aspectRatio?: number;
}

export interface CropResult {
  path: string;
  base64?: string;
}
