clean:
	find . -name "*.class" -type f -delete

keyboardAnimation: examples/KeyboardAnimation.java 
	javac examples/KeyboardAnimation.java; java examples.KeyboardAnimation