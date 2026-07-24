# Roadmap

## Phase 0: Definition and visual direction

- [x] Name and project concept
- [x] Define the first feature roadmap
- [X] Choose final repository name and visual identity

## Phase 1: Android foundation

- [X] Create the Kotlin/Jetpack Compose Android project
- [X] Set minimum and target Android versions
- [ ] Add a simple Material 3 Expressive theme
- [ ] Add light/dark system theme support
- [ ] Add basic navigation between Home and Editor

## Phase 2: First usable editor

- [ ] Render a custom wallpaper canvas
- [ ] Add circles, rounded rectangles, polygons and lines
- [ ] Select an object by tapping it
- [ ] Drag objects around the canvas
- [ ] Pinch to scale objects
- [ ] Rotate objects with two-finger gestures
- [ ] Add, duplicate and delete objects
- [ ] Add a simple layer list and z-order controls
- [ ] Add undo and redo
- [ ] Save and restore a local project

## Phase 3: Colours and composition

- [ ] Choose a seed colour
- [ ] Generate a Material-style tonal palette
- [ ] Apply palette roles to shapes and backgrounds
- [ ] Support custom colours and complete user palettes
- [ ] Add opacity, outline, fill and dotted-fill options
- [ ] Add curated composition presets
- [ ] Add alignment guides, snapping and safe areas
- [ ] Add visual balance and contrast rules

## Phase 4: Automatic wallpaper generation

- [ ] Add a random wallpaper action from the Home screen
- [ ] Generate compositions from templates and constraints
- [ ] Add minimum spacing and canvas-boundary rules
- [ ] Detect approximate shape overlaps
- [ ] Offer intentional overlap as an optional style
- [ ] Add generation moods such as Calm, Playful, Bold and Organic
- [ ] Allow generated wallpapers to be opened in the editor
- [ ] Add regenerate, lock and vary controls

## Phase 5: Export and device support

- [ ] Detect display dimensions and density
- [ ] Allow manual canvas dimensions and aspect ratios
- [ ] Support lock-screen and home-screen exports
- [ ] Support separate cover and unfolded layouts for foldables
- [ ] Add wallpaper-safe areas and crop previews
- [ ] Export PNG files at the selected resolution
- [ ] Apply wallpapers through Android WallpaperManager
- [ ] Add share and save-to-gallery actions

## Phase 6: Images and richer objects

- [ ] Import images from the Android photo picker
- [ ] Place images inside supported shapes
- [ ] Crop, scale and reposition image contents
- [ ] Add image tint, blur and duotone treatments
- [ ] Extract colours from imported images
- [ ] Add texture and pattern fills
- [ ] Add custom SVG-like paths or additional shape types

## Phase 7: Home experience and presets

- [ ] Design the Home screen around Saved, Featured and Create
- [ ] Add saved wallpaper thumbnails
- [ ] Add editable preset collections
- [ ] Add favourites and recently edited projects
- [ ] Add a featured section using bundled wallpapers initially
- [ ] Add a polished empty state
- [ ] Add a random wallpaper button to the create flow

## Phase 8: Quality and accessibility

- [ ] Test across phones, tablets and foldables
- [ ] Test portrait, landscape, folded and unfolded states
- [ ] Add accessibility labels and larger touch targets
- [ ] Support reduced motion where practical
- [ ] Optimise rendering and export memory usage
- [ ] Add automated tests for palette generation and collision rules
- [ ] Add UI tests for core editing gestures
- [ ] Add crash reporting only if it remains privacy-respecting

## Phase 9: Optional community features

- [ ] Export/import project files
- [ ] Share preset files directly
- [ ] Optional online featured-wallpaper catalogue
- [ ] User submissions and moderation workflow
- [ ] Optional accounts and cloud backup
- [ ] Optional community browsing and remixing

> [!NOTE]
> This roadmap was generated in part by AI to help come up with goals for Motif.
