# Tình Birthday Mobile Website

Branch: `birthday-tinh-mobile`

Static mobile-first birthday experience for Tình.

## Render deploy

- Build command: empty
- Publish directory: `.`
- Entry file: `index.html`

`render.yaml` is included for Render static deploy.

## Assets to add

Put these files into `assets/`:

| File | Use |
| --- | --- |
| `assets/dalat-night.jpg` | Hero ảnh Đà Lạt ban đêm |
| `assets/dalat-mood.jpg` | Polaroid/camera roll ảnh Đà Lạt |
| `assets/graduation.jpg` | Màn level completed/tốt nghiệp |
| `assets/gift-memory.jpg` | Memory quà sinh nhật 4 năm trước |
| `assets/squad.jpg` | Ảnh nhóm Long, Tình, Lợi, Trung |

The page still loads with gradient fallbacks if images are missing, but it is designed to look best after adding the 5 assets.
