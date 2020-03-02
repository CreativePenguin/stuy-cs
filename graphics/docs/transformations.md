# Transformations -- 2/24
- Scale, Translate, Rotate
- Applied as matrix multiplication
## Scale
- Scale `(x, y, z) --> (ax, by, cz)`
```
[a 0 0 0][x] = [ax]
[0 b 0 0][y] = [by]
[0 0 c 0][z] = [cz]
[0 0 0 1][1] = [1]
```
This will also cause the shape to shift as well
## Translate
- Transform `(x, y, z) --> (x + a, y + b, z + c)`
```
[1 0 0 a][x] = [x + a]
[0 1 0 a][y] = [y + b]
[0 0 1 a][z] = [z + c]
[0 0 0 1][1] = [  1  ]
```
## Rotate
- Rotate z axis `(x, y, z) --> (xcost - ysint, xsint + ycost, z)`
```
[cost -sint 0 0][x]
[sint cost  0 0][y]
[  0    0   1 0][z]
[  0    0   0 1][1]
```
- Rotate x axis `(x, y, z) --> (x, ycost - zsint, ysint + zcost)`
```
[1  0     0   0][x]
[1 cost -sint 0][y]
[1 sint  cost 0][z]
[1  0     0   1][1]
```
- Rotate y axis `(x, y, z) --> (xcost + zsint, y, -xsint + zcost)`
```
[-sint 0 cost 0]
[  0   1  0   0]
[ cost 0 sint 0]
[  0   0  0   1]
```
## Combining Transformations
