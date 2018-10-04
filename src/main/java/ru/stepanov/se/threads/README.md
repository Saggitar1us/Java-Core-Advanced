## Задание
##### Необходимо написать два метода, которые делают следующее:
 - Создают одномерный длинный массив, например:
  ```java
  static final int size = 10 000 000;
  static final int h = size / 2;
  float[] arr = new float[size].
  ```
 - Заполняют этот массив единицами.
 - Засекают время выполнения: long a = System.currentTimeMillis().
 - Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 ```java
 arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)).
 ```
- Проверяется время окончания метода System.currentTimeMillis().
- В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a).

##### Отличие первого метода от второго:
Первый просто бежит по массиву и вычисляет значения.
Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.

###### Пример деления одного массива на два:
> System.arraycopy(arr, 0, a1, 0, h);
System.arraycopy(arr, h, a2, 0, h).

###### Пример обратной склейки:
>System.arraycopy(a1, 0, arr, 0, h);
System.arraycopy(a2, 0, arr, h, h).