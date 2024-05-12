#include <stdio.h>
/************************************************************************************************
    Este codigo es para Ejecutar un Hola Mundo desde un Hilo de un bloque perteneciente a un Grid
    Primero ejecuta el codigo de Bloque para que hagas tus modificaciones y asi experimentes
    Solo dice Hola
 ************************************************************************************************/
__global__ void helloFromGPU() {
    printf("Hola Mundo desde el hilo %d del bloque %d del grid %d.\n",
           threadIdx.x, blockIdx.x, gridDim.x);
}

int main() {
    // Configuración de la grilla y los bloques
    dim3 threadsPerBlock(2); // 16 hilos por bloque
    dim3 numBlocks(4);        // 4 bloques en el grid
    //Si multiplicamos estos 2 valores nos da el numero total de hilos

    // Llamada al kernel
    helloFromGPU<<<numBlocks, threadsPerBlock>>>();

    // Espera a que finalicen todos los kernels
    cudaDeviceSynchronize();

    return 0;
}