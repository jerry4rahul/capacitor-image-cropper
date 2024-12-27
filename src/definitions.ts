export interface ImageCropperPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
