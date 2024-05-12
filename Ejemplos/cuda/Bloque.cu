#include <stdio.h>
/************************************************************************************************
    En este archivo nos ayudara para ver cuantos devices o GPUs tenemos en nuestro ordenador
    Normalmente solo tendremos 1
    Ademas, nos indica el numero Maximo de Threads per block, o en español hilos por bloque.
    ASi como como el numero maximo de blocks per grid, o bloques en la malla (veanlo como arreglo 2d)
    Esto nos ayudara a configurar otros archivos que vallamos trabajando.
    NO SOBREPASAR EL NUMERO MAXIMO
 ************************************************************************************************/


/**
 * @brief Metodo main
 * 
 * @return int 0 si todo salio bien
 */
int main() {
    int deviceCount;
    cudaGetDeviceCount(&deviceCount);

    for (int dev = 0; dev < deviceCount; ++dev) {
        cudaDeviceProp deviceProp;
        cudaGetDeviceProperties(&deviceProp, dev);
        
        printf("Device %d: %s\n", dev, deviceProp.name);
        printf("  Maximum threads per block: %d\n", deviceProp.maxThreadsPerBlock);
        printf("  Maximum blocks per grid: %d\n", deviceProp.maxGridSize[0]);
    }

    return 0;
}