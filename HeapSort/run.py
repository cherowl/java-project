from multiprocessing import Process
from time import sleep
import os

class A:
    def __call__(self, count=10, sleep_time=0.0):
        os.system("python3.5 speech.py")
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




