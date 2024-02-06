#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *imprime(void *ptr){
    char *msg;
    msg = (char *) ptr;
    printf("Hola soy el: %s \n", msg);
    return 0;
}

int main(){
    pthread_t hilo1, hilo2, hilo3;
     char *id1 = "Soy el hilo 1";
     char *id2 = "Soy el hilo 2";
     char *id3 = "Soy el hilo 3";
     int ret1, ret2, ret3;
     
     ret1 = pthread_create(&hilo1, NULL, imprime, (void *) id1);

     if(ret1 != 0){
         printf("Error al crear el hilo 1");
         exit(1);
     }

     ret2 = pthread_create(&hilo2, NULL, imprime, (void *) id2);

    if(ret2 != 0){
         printf("Error al crear el hilo 2");
         exit(1);
     }

     ret3 = pthread_create(&hilo3,NULL,imprime, (void *) id3);

     if(ret3 != 0){
         printf("Error al crear el hilo 3");
         exit(1);
     }

     pthread_join(hilo1, NULL);
     pthread_join(hilo2, NULL);
     pthread_join(hilo3, NULL);
    printf("proceso Finalizado\n");
     return 0;
}