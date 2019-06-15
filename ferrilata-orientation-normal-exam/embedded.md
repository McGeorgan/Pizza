# Embedded

## Keep in mind

The C exercises have to make sure about the followings:

- Compiles
- Does not have any undefined behaviour
- You don't use more memory than necessary
- Deallocates the memory when it's no longer used
- Does not crash

The embedded exercises have to make sure about the followings:

- Compiles
- Does not have any undefined behaviour
- Does not crash
- Does not use any blocking mechanism (like HAL_Delay() or HAL_UART_Receive())


# Buses

## Structure

Create a bus structure where you store:
  - name of the bus
  - number of seats
  - number of standing places
  - number of passengers currently on the bus

## Main

Store different type of buses in main() in an array.

## Function

### Get on the bus

Create a function for get on the bus. 
The number of new passengers should be passed as a parameter.

### Get off the bus

Create a function for getting off the bus. 
The number of passengers who are getting off should be passed as a parameter.


### Printing

Each time these functions are called, they should print out the current capacity (the number of free seats and standing places).
First the passengers fill up all the seats, and then the standing places when they get on the bus.
When they get off the bus, the standing places will be released first.

#### EXAMPLE

An Ikarus 280 has 147 standing places and 36 seats this means it can carry 183 person.
- We start with an empty bus. First there are 50 new passengers. So after the get on function called it should inform us:
    - We have 50 passengers. There is 0 empty seats and 133 standing places left.
- Then we call the get off function with 20 passengers. This time it should print out something like this:
    - We have 30 passengers. There is 0 seats left and 153 standing places.
- If too much passengers wants to get in, our function simply should inform us: 
    - that this is too much for this bus and pass without any further action.

### Largest capacity

Create a function which takes the whole bus array as a parameter and returns the name of the bus with the largest capacity (the number of free seats + the number of free standing places).

# Vowels

Write a function that takes the name of a text file as a parameter and counts the number of vowels in the file!

The function should do two things:
- Count and *return* the number of vowels
- Write the vowels to another file called *just_some_vowels.txt*

The input file can be found here: [input.txt](input.txt).

## Example solution

 **input.txt**:
```txt
Lorem ipsum dolor sit
```

**Function return value:** 7

**just_some_vowels.txt**:
```txt
oeiuooi
```
# Pedestrian crossing simulator

You will create a pedestrian crossing simulator, which is able to change it's state: red and green light.
You will use the blue user button to signal your intent to come accross.

#### Specification

 - Connect 2 external LED to the board!
 - Your applications should be able to state the change of the 2 LED:
    - when the green is on, the red is off, and vice versa
    - by default, the green LED is on for 3 seconds, then the red is on for 7 seconds, then this process is repeated continuously
 - If you press the user button, the length of the actual red light will be shortened. After you press it, the red light phase completes within 1 second, if it won't be longer as the original red light's end time.
 - That button press
    - has only effect to the actual red light phase
	- if you press it during the green light phase, it has no effect
	- if you press the button multiple times during the red phase, it has the same effect, as if you'd pressed the button only once
 - Your application should tell the user the state changes. Use the USART1 peripheral and the serial monitor.
 
#### Example

 - In default state, you should see in the serial monitor:

```
Changed to red, please wait for 6 seconds.
Changed to green, you can come across.
Changed to red, please wait for 6 seconds.
Changed to green, you can come across.
```

- Pressing the button (even multiple times), during the red light phase, you should see in the serial monitor:

```
Intention to come accross, wait 1 second.
Changed to green, you can come across.
Changed to red, please wait for 6 seconds.
```

#### Non-functional requirements

 - You should use at least 1 timer peripheral
 - Try to avoid the use of blocking waiting mechanisms (like HAL_Delay())
 - Use external interrupt


### - What are the main advantages of using a general purpose timer for timing purpose, over using HAL_Delay()?
*type your answer here (please explain with your own words)*

### - What is the pull-up/pull-down resistor?
*type your answer here (please explain with your own words)*


