Here are a few examples to get you started on your games.  Please note that these are not necessarily OO solutions, and probably require additional work in your own projects (for example, we probably don't want an animation to only render on key pres...).

### SimpleAnimation
Moves a tank image across a background.
```
javac examples/SimpleAnimation.java
java examples.SimpleAnimation
```

### KeyboardAnimation
Shows a (poorly implemented) explosion animation.  Response to the keys:
* left arrow
* right arrow
* up arrow
* down arrow
* F (for fire)
```
javac examples/KeyboardAnimation.java
java examples.KeyboardAnimation
```

### NetworkAnimation
Shows an example of how to connect a client "game" to a host "game".  The host in this example simply waits to receive keys from the connected client, and responds to those.  You must start the host before the client, and the host will not be visible until the client connects.
```
javac examples/NetworkExample.java
javac examples/KeyBroadcastFrame.java

java examples.NetworkExample
# In a separate shell:
java examples.KeyBroadcastFrame
```