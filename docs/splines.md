# Splines -- 3/3/2020
> Curves (cubic) that appeared to be smooth/continuous
## Bezier
Defined By: 2 Endpoints (P0, P3)  
            2 Influence Points(P1, P2)  
![bezier_demo.jpg](images/bezier_ex.jpg)
Influence points pull the curve  
Quadratic curve would only have on influence point  
### Line
![parametric_line.jpg](images/parametric_line.jpg)
Pt = (1 - t)P0 + tP1

### Quadratric
![bezier_quadratic.gif](images/bezier_quadratic.gif)
Q0 = (1 - t)Q0 + tQ1  
Q0t = (1 - t)P0 + tP1  
Q1t = (1 - t)P1 + tP2  
Qt = (1 - t)[(1 - t)P0 + tP1] + t[(1 - t)P1 + tP2]  
**Qt = (1 - t)<sup>2</sup>P0 + 2t(1 - t)P1 + t<sup>2</sup>P2**  

### Cubic
![bezier_cubic.gif](images/bezier_cubic.gif)

O = (1 - t)S + tT  
S = (1 - t)<sup>2</sup>A + 2t(1 - t)B + t<sup>2</sup>C  
T = (1 - t)<sup>2</sup>B + 2t(1 - t)C + t<sup>2</sup>D  
O = (1 - t)[(1 - t)<sup>2</sup>A + 2t(1 - t)B + t<sup>2</sup>C] + t[(1 - t)<sup>2</sup>B + 2t(1 - t)C + t<sup>2</sup>D]  
O = (1 - t)<sup>3</sup>A + 3t(1 - t)<sup>2</sup>B + 3t<sup>2</sup>(1 - t)C + t<sup>3</sup>D  
**(-A + 3B - 3C + D)t<sup>3</sup> + (3A - 6B + 3C)t<sup>2</sup> + (-3A + 3B)t + A**  
Form: at<sup>3</sup> + bt<sup>2</sup> + ct + d

## Hermite
Defined By: 2 endpoints: P0, P1  
            Rates of change at each endpoint : R0, R1  
Hermite curves are better when you're typing instructions rather than clicking and drawing things  
f(t) = at<sup>3</sup> + bt<sup>2</sup> + ct + d  *Points on curve*  
f'(t) = 3at<sup>2</sup> + 2bt + c  *Rates of change*  
f(0) = d *P0*  
f(1) = a + b + c + d *P1*  
f'(0) = C *R0*  
f'(1) = 3a + 2b + c *R1*  
