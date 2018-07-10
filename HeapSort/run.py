from multiprocessing import Process
from time import sleep
import os

class A:
    def __call__(self, count=10, sleep_time=0.0):
<<<<<<< HEAD
        os.system("python3.5 speech.py")
=======
        os.system("python3.5 tts_Engin.py")
>>>>>>> a088c8de0b752de90b2bfa7875db1afdbfee58de
        sleep(sleep_time)
        


class B:
    def __call__(self, count=10, sleep_time=2):
        os.system("java -jar HeapSort.jar" )
        sleep(sleep_time)


if __name__ == '__main__':
    a = A()
    b = B()

    p1 = Process(target=a, kwargs={'sleep_time': 0.0})
    p2 = Process(target=b, args=(12,))
    
    p1.start()
    sleep(7)
    p2.start()
    p1.join()

    p2.join()




