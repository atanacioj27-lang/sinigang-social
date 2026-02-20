# Sinigang Social

Sinigang Social is a single-file social app prototype built with plain HTML, CSS, and JavaScript.

## What’s new in this revision

- refreshed app controls with **theme toggle** and **reset local data** actions
- safer rendering updates and account-state consistency improvements
- cleaner build script and updated project metadata

## Features

- Login and sign-up (localStorage-based)
- Feed with stories, IP tracking, live camera preview, and group chat
- Group creation and chat notifications
- Profile reporting + email-based user search
- Account settings (email/password update, privacy flags, delete account)
- Settings logs (security and reports), backup/restore, and app controls
- Light/Dark theme preference persisted in localStorage

## Project structure

- `sc` – primary app source (HTML/CSS/JS)
- `build.sh` – builds `dist/index.html` from `sc`
- `package.json` – scripts for build and local serve
- `README.md` – project documentation

## Commands

```bash
npm run build
npm run serve
```

Open the app at: `http://127.0.0.1:4173/dist/index.html`

## Notes

This project is a demo and does not implement production-grade authentication or backend validation.
