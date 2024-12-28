# Capacitor Image Cropper

A Capacitor plugin designed specifically for Android and iOS platforms. It enables users to easily crop images with intuitive controls, offering seamless integration for mobile app development. Ideal for applications requiring on-device image editing.

## Install

```bash
npm install y
npx cap sync
```

## API

<docgen-index>

- [`crop(...)`](#crop)
- [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### crop(...)

```typescript
crop(options: CropOptions) => Promise<CropResult>
```

| Param         | Type                                                |
| ------------- | --------------------------------------------------- |
| **`options`** | <code><a href="#cropoptions">CropOptions</a></code> |

**Returns:** <code>Promise&lt;<a href="#cropresult">CropResult</a>&gt;</code>

---

### Interfaces

#### CropResult

| Prop         | Type                |
| ------------ | ------------------- |
| **`path`**   | <code>string</code> |
| **`base64`** | <code>string</code> |

#### CropOptions

| Prop              | Type                |
| ----------------- | ------------------- |
| **`source`**      | <code>string</code> |
| **`quality`**     | <code>number</code> |
| **`width`**       | <code>number</code> |
| **`height`**      | <code>number</code> |
| **`aspectRatio`** | <code>number</code> |

</docgen-api>
