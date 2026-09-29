# Practical-7: Media Player Service with Playback Controls

**Student Name:** Prince Patel  
**Student Enrollment Number:** 24012011120  
**Course:** Mobile Application Development (2CEIT5PE18)  
**IDE:** Android Studio  

---

## Aim
Create an Android Media Player application with full playback control options (Play, Pause, Stop, Previous, Next, Shuffle) and custom UI design using Android Service and MediaPlayer.

## Overview
This application demonstrates background audio playback using an Android Service (MusicService). It provides a modern user interface featuring album artwork (poster.png) and custom control buttons.

## Key Features
- **Background Audio Service**: Audio playback continues even when navigating away from the activity.
- **Playback Controls**:
  - Play / Pause: Start and toggle audio playback.
  - Stop: Stops the media player service.
  - Previous / Next: Navigate through tracks.
  - Shuffle: Toggle shuffle mode.
- **Custom UI Layout**: ConstraintLayout with MaterialCardView, custom vector drawable buttons, and album artwork.

## Project Components
- MainActivity.kt: Handles button clicks and sends action intents to MusicService.
- MusicService.kt: Service class managing the MediaPlayer lifecycle and audio playback (song.mp3).
- ctivity_main.xml: Media player layout design with controls and poster display.
- AndroidManifest.xml: Declares MusicService and required permissions.

---

## Output Screenshots

### 1. Album Artwork & Media Player Interface
![Media Player Interface](Screenshots/7_1.png)

---

## Conclusion
The application successfully demonstrates background media playback, service lifecycle management, and customized audio player controls in Android.
