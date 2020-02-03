Line Algorithm
###############

| Input: 2 pixel endpoints. Output: Line that connects two inputs
| Problem: in order for line to be accurate, it would need to be able to draw on the subpixel level, which is impossible
| Potential Solutions: Test Potential Pixels, iterate through potential pixels

.. image:: octants.jpg
  :width: 400px
  :align: center

| Today's task will be to develop a line algorithm that only works in octant I.
| Thus, we only need to turn on one pixel per x
| Algorithm is basically:
1. Loop through x0 to x1
2. TEST(x + 1, y) TEST(x + 1, y + 1)
3. Pick best point 
