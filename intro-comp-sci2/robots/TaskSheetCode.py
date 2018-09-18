import time
import easygopigo3 as easy
gpg=easy.EasyGoPiGo3()
serv=gpg.init_servo()
dist=gpg.init_distance_sensor()

def square(side_length):
    i=0
    while i < 4:
        gpg.drive_inches(side_length)
        gpg.turn_degrees(90)
        time.sleep(1)
        i+=1
    gpg.stop()
    print gpg.volt()

#square(8)

def ngon(n,side):
    i=0
    while i < n:
        gpg.drive_inches(side)
        gpg.turn_degrees(360/n)
        time.sleep(1)
        i+=1
    gpg.stop()
    print gpg.volt()

#ngon(8,3)

def square2(side_length):
    side = side_length
    left,right=gpg.read_encoders()
    for x in range(4):
        motorInit(25)
        gpg.forward()
        while encoderToInches(right) <= side:
            right = gpg.read_encoders()[1]
        print encoderToInches(right),side
        gpg.stop()
        time.sleep(1)
        gpg.turn_degrees(90)
        side += side_length
        print "side done"
    print "all done"

def motorInit(n):
    gpg.set_motor_dps(gpg.MOTOR_LEFT,n)
    gpg.set_motor_dps(gpg.MOTOR_RIGHT,n)

def encoderToInches(n):
    return (8.262388 * n) / 360
def inchesToEncoder(n):
    return (360 / 8.262386) * n

def wink(on,off):
    ledInit((255,0,0))
    for x in range(10):
        gpg.open_eyes()
        time.sleep(on)
        gpg.close_eyes()
        time.sleep(off)

def wink_fast():
    ledInit((0,255,0))
    i = .25
    for x in range(10):
        i *= .5
        wink(.25,off)


def ledInit(n):
    gpg.set_right_eye_color(n)
    gpg.set_left_eye_color(n)

wink(2,4)
#square2(2)
print gpg.volt()
#gpg.stop()
