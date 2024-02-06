import threading

def cuenta(name):
    print("Hola soy el: "+ name)

t1 = threading.Thread(target=cuenta, args=("hilo 1",))
t2 = threading.Thread(target=cuenta, args=("hilo 2",))
t3 = threading.Thread(target=cuenta, args=("hilo 3",))

t1.start()
t2.start()
t3.start()

t1.join()
t2.join()
t3.join()