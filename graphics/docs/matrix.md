# Matrixes In Graphics

- Matrixes store significant endpoints of images
  - Each pair of entries = edge

```
[x0 x1 x2 xN]
[y0 y1 y2 yN]
[z0 z1 z2 zN]
 P0 P1 P2 P3
```

## Matrix Multiplication

The column of the first = the row of the second
Set Z to zero for now
Make sure that if you're coding in C, make the matrixes doubles
Note that this example is basically `matrix * itself`, if you multiply by a zero
matrix, it will erase your entire matrix  
```
0[1 0 0]   [x0 x1 xN]
1[0 1 0] * [y0 y1 yN]
2[0 0 1]   [z0 z1 zN]
```
Ex.  
```
[4 0 0]   [x0 x1 xN]   [4x0 4x1 4xN]
[0 3 0] * [y0 y1 yN] = [3y0 3y1 3yN]
[0 0 2]   [y0 y1 yN]   [2y0 2y1 2yN]
```

Note, the average matrix should look like this:  
> The 1 1 1 there on the bottom is boilerplate code
```
[x0 x1 xN]
[y0 y1 yN]
[z0 z1 zN]
[1  1  1]
```
