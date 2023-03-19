# ABSORB

A clojurescript game.

### Status
- Board renders and you can click to toggle showing a game piece.
- No game logic yet.
- Unit tests are not implemented, but the framework is in place.

## Development Mode

### cljs-devtools

To enable:

1. Open Chrome's DevTools,`Ctrl-Shift-i`
2. Open "Settings", `F1`
3. Check "Enable custom formatters" under the "Console" section
4. close and re-open DevTools

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

### Run tests:

```
lein clean
lein doo chrome test once
```

The above command assumes that you have [karma](https://www.npmjs.com/package/karma) installed. However, please note that [doo](https://github.com/bensu/doo) can be configured to run cljs.test in many other JS environments (phantom, ie, safari, opera, slimer, node, rhino, or nashorn). 

## Production Build

```
lein clean
lein cljsbuild once min
```

## Design

A [reagent](https://github.com/reagent-project/reagent) single page application.

