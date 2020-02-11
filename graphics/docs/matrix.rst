Matrixes In Graphics
********************
| - We will store all the significant endpoints of our images in a single list/matrix
| - We will maintain an edge matrix, where each pair of entries defines an edge

..::code:`[P0 P1 P2 P3 .... PN]`

| - Points are (x, y) or (x, y, z) coordinates::

  [x0 x1 x2 xN]
  [y0 y1 y2 yN]
  [z0 z1 z2 zN]
   P0 P1 P2 PN

Matrix Multiplication
#####################
M0 * M1 != M1 * M0
Can only work if # cols in M0 == #rows in M1

.... code-block:: python
  [1 2 3] * [a d]


identity matrix -- how we do transformations -- I got really confused here :(
