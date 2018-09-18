breed [pawns pawn]
breed [muskets musket]
breed [bullets bullet]
breed [kamikazis kamikazi]
breed [ninjas ninja]
breed [medics medic]
breed [snipers sniper]

breed [walls wall]
turtles-own [health  speed   opposite-color   hit-chance]
patches-own [walls-built]
bullets-own [team age]
globals [click? shot]

to setup
  clear-all
  reset-ticks
  set-default-shape bullets "circle"
  ask patches with [pxcor = 0] [set pcolor white]
  ask patches with [pxcor < 0] [set pcolor 18]
  ask patches with [pxcor > 0] [set pcolor 108]
  set shot 0
end

to go
  reset-field-colors
  repeat time-between-fire [
    ask muskets [musketstuff]
    ask pawns [pawnstuff]
    ask bullets [bulletstuff]
    ask kamikazis [kamikazistuff]
    ask ninjas [ninjastuff]
    ask turtles [set-opponent]
    ask walls [die?]
    ask turtles with [not (breed = bullets) and not (breed = walls) and not (breed = ninjas)] [
      if show-health [set label health]
      terrain?
      die?
    ]
    tick
  ]
  ask muskets [shoot]
  ask medics [heal]
  if shot = 10 [
    ask snipers [sniper-shoot]
    set shot 0
  ]
end

to killspawn
  ask turtles with [xcor = 0 and ycor = 0] [die]
end


;END OF PLACE TROOPS


to reset-field-colors
  reset-color 108
  reset-color 18
  reset-color white
end

to reset-color [x]
  if any? patches with [pcolor = x] [
    ask patches with [pcolor = x] [set pcolor black]
  ]
end


;TURTLE COMMANDS


to set-opponent
  if color = red [set opposite-color blue]
  if color = blue [set opposite-color red]
end

to die?
  if health <= 0 [die]
end

to melee-move
  if any? turtles with [color = [opposite-color] of myself] in-cone (max-pxcor) vision-angle [
    face min-one-of turtles with [
      color = [opposite-color] of myself] in-cone max-pxcor vision-angle
      [distance myself]
      ]
      fd speed
end


to range-move
  if not any? turtles with [color = [opposite-color] of myself] in-cone vision-range vision-angle [
    fd speed
    rt random 3
    lt random 3
  ]
end

to heal-move
  if any? turtles with [color = [color] of self] [
    face min-one-of turtles with [not (breed = kamikazis) or not (breed = medics)] [health-value - health]
  ]
end

to musketstuff
  range-move
end

to ninjastuff
  melee-move
  if any? turtles with [color = [opposite-color] of myself][bop]
  if show-health [set label health]
  die?
end

to medicstuff
  heal-move
end

to bulletstuff
  set age age + 1
  fd 1
  hitbullet
  age-bullet
end

to bulletshoot
  hatch 1 [
    set label " "
    set breed bullets
    set size 0.5
    set team color
    set color white
    rt random 30
    lt random 30
    ]
end

to shoot
  if any? turtles with [color = [opposite-color] of myself] in-cone vision-range vision-angle [
      bulletshoot
      face one-of turtles with [color = [opposite-color] of myself] in-cone vision-range vision-angle
    set shot (shot + 1)
  ]
end

to sniper-shoot
  face min-one-of turtles [distance myself]
  bulletshoot
end

to hitbullet
  if any? other turtles-here with [not (color = [team] of myself)] [
    ask turtles-here  [
      if random hit-chance = 0 [
        set health health - (90 + random 40)
      ]
    ]
    die
  ]
end

to age-bullet
  if age > 32 [die]
end

to pawnstuff
   if any? turtles with [color = [opposite-color] of myself][bop]
  melee-move
end

to bop
  ask turtles in-radius 0.5 with [color = [opposite-color] of myself] [
    set health health - 30
    bk 2
  ]
end

to kamikazistuff
  if any? turtles with [color = [opposite-color] of myself][kms]
  melee-move
end

to kms
  if any? turtles in-radius 1 with [color = [opposite-color] of myself][
    ask patch-here [
      ask neighbors [
      repeat 4 [
        set pcolor yellow
        set pcolor black
      ]
    ]
    ask turtles in-radius 1 [die]
   ]
  ]
end

to heal
  if any? turtles in-radius 5 with [color = [color] of myself] [
    ask turtles in-radius 5 with [color = [color] of myself] [
      if (health + 5) < health-value [
        set health health + 5
      ]
    ]
  ]
end

;;TERRAIN CODE

to terrain?
  on-land
  in-grass
  wall-in-sight
  in-trench
end

to on-land
  if pcolor = black[
  set speed movement-value
  set hit-chance 0
  ]
end

to in-grass
  if pcolor = green
    [set speed movement-value / 2]
end

to wall-in-sight
  ifelse any? turtles in-radius vision-range with [color = orange]
    [set opposite-color orange][
      ifelse color = blue
       [set opposite-color red]
       [set opposite-color blue]
  ]
end

to in-trench
  if (breed = muskets) [
   if pcolor = brown [
     ifelse any? turtles with [color = [opposite-color] of myself and not (pcolor = brown)] in-cone (vision-range * 2) vision-angle [
      set speed 0
      set hit-chance 1
    ]
      [set speed movement-value]
   ]
  ]
end



;;CONSTANT VALUES



to-report health-value
  if breed = pawns [report 120]
  if breed = muskets [report 75]
  if breed = kamikazis [report 25]
  if breed = ninjas [report 75]
  if breed = medics [report 50]
  if breed = snipers [report 50]
end

to-report movement-value
  if breed = pawns [report 0.2]
  if breed = muskets [report 0.2]
  if breed = kamikazis [report 0.2]
  if breed = ninjas [report 0.6]
  if breed = medics [report 0.4]
end


;PLACEMENT COMMANDS

to place-red
  if troop-type = "muskets" [place-musket red]
  if troop-type = "pawns" [place-pawn red]
  if troop-type = "kamikazis" [place-kamikazi red]
  if troop-type = "ninjas" [place-ninja red]
  if troop-type = "medics" [place-medic red]
  if troop-type = "snipers" [place-sniper red]
end

to place-blue
  if troop-type = "muskets" [place-musket blue]
  if troop-type = "pawns" [place-pawn blue]
  if troop-type = "kamikazis" [place-kamikazi blue]
  if troop-type = "ninjas" [place-ninja blue]
  if troop-type = "medics" [place-medic blue]
  if troop-type = "snipers" [place-sniper blue]
end

to redspawn [hp]
  if mouse-xcor < 0 [
  set color red
  set heading 90
  setxy mouse-xcor mouse-ycor
  set health hp
  set speed 0.2
  set click? 1
  ]
end

to bluespawn [hp]
  if mouse-xcor > 0 [
  set color blue
  set heading 270
  setxy mouse-xcor mouse-ycor
  set health hp
  set speed 0.2
  set click? 1
  ]
end

to place-musket [x]
    ifelse mouse-inside? and mouse-down? [
    if click? = 0 [
      if x = red [
        create-muskets 1 [ redspawn 75]
       ]
      if x = blue [
        create-muskets 1 [bluespawn 75]
      ]
    ]
  ]
  [set click? 0]
  killspawn
  tick
end

to place-pawn [x]
   ifelse mouse-inside? and mouse-down? [
    if click? = 0 [
      if x = red [
        create-pawns 1 [redspawn 100]
       ]
      if x = blue [
        create-pawns 1 [bluespawn 100]
      ]
    ]
  ]
  [set click? 0]
  killspawn
  tick
end

to place-kamikazi [x]
  ifelse mouse-inside? and mouse-down?  [
    if click? = 0 [
      if x = red [
        create-kamikazis 1 [redspawn 25]
       ]
      if x = blue [
        create-kamikazis 1 [bluespawn 25]
      ]
    ]
  ]
  [set click? 0]
  killspawn
  tick
end

to place-ninja [x]
  ifelse mouse-inside? and mouse-down? [
    if click? = 0 [
      if x = red [ create-ninjas 1 [redspawn health-value] ]
      if x = blue [ create-ninjas 1 [bluespawn health-value] ]
    ]
  ]
  [set click? 0]
  killspawn
  tick
end

to place-medic [x]
  ifelse mouse-inside? and mouse-down?  [
    if click? = 0 [
      if x = red [
        create-medics 1 [redspawn 25]
       ]
      if x = blue [
        create-medics 1 [bluespawn 25]
      ]
    ]
  ]
  [set click? 0]
  killspawn
  tick
end

to place-sniper [x]
  ifelse mouse-inside? and mouse-down?  [
    if click? = 0 [
      if x = red [
        create-snipers 1 [redspawn 25]
       ]
      if x = blue [
        create-snipers 1 [bluespawn 25]
      ]
    ]
  ]
  [set click? 0]
  killspawn
  tick
end

to formationspawn [col bred spd hed]
  sprout 1 [
    set color col
    set breed bred
    set speed spd
    set heading hed
  ]
end

to formationspawn2
  ask turtles [
    set health health-value
    set speed movement-value
  ]
end

to place-troop-formation-red
  if troop-formation = "total mayhem" [
  ask n-of 100 patches with [pxcor < 0][
      formationspawn (red) (kamikazis) (0.2) (90)
    ]
    formationspawn2
  ]
  if troop-formation = "british army" [
    ask patches with [pxcor < 0 and remainder pxcor 10 = 0][
      formationspawn (red) (muskets) (0.2) (90)
    ]
    formationspawn2
  ]
end

to place-troop-formation-blue
  if troop-formation = "total mayhem" [
  ask n-of 100 patches with [pxcor > 0][
      formationspawn (blue) (kamikazis) (0.2) (270)
    ]
    formationspawn2
  ]
  if troop-formation = "british army" [
    ask patches with [pxcor > 0 and remainder pxcor 10 = 0][
      formationspawn (blue) (muskets) (0.2) (270)
    ]
    formationspawn2
  ]
end



;Place Terrain Code



to place-terrain
  if terrain-type = "grass" [place-grass]
  if terrain-type = "wall" [place-wall]
  if terrain-type = "trench" [place-trench]
end

to place-stuffs-terrain [x]
  if mouse-inside? and mouse-down? [
    ask patch mouse-xcor mouse-ycor [set pcolor x]
  ]
  tick
end

to place-grass
  place-stuffs-terrain green
end

to place-trench
  place-stuffs-terrain brown
end

to place-wall
   if mouse-inside? and mouse-down? [
    ask patch mouse-xcor mouse-ycor [
      if walls-built = 0 [
        sprout 1 [
          set breed walls
          set color orange
          set shape "square"
          set health 250
        ]
        set walls-built 1
      ]
    ]
  ]
  tick
end

to place-terrain-formation
  if terrain-formation = "grassy field"
    [ask patches [set pcolor green]]
  if terrain-formation = "western front"
    [trench-war]
end

to trench-war
  ask patches with [pxcor = -10 or pxcor = 10 or pxcor = -16 or pxcor = 16][
    set pcolor brown
    ask neighbors [set pcolor brown]
  ]
  ask patches with [pxcor > -9 and pxcor < 9]
    [set pcolor green]
  ask n-of 30 patches with [pxcor > -9 and pxcor < 9][
    sprout 1 [
      set color orange
      set breed walls
      set shape "square"
      set health 250
    ]
    set walls-built 1
  ]
end
@#$#@#$#@
GRAPHICS-WINDOW
179
131
1032
569
-1
-1
13.0
1
10
1
1
1
0
1
1
1
-32
32
-16
16
1
1
1
ticks
30.0

BUTTON
44
31
107
64
NIL
setup
NIL
1
T
OBSERVER
NIL
NIL
NIL
NIL
1

SLIDER
858
79
1030
112
vision-angle
vision-angle
15
90
60.0
1
1
NIL
HORIZONTAL

SLIDER
858
48
1030
81
vision-range
vision-range
6
24
18.0
1
1
NIL
HORIZONTAL

SLIDER
858
17
1030
50
time-between-fire
time-between-fire
1
100
4.0
1
1
NIL
HORIZONTAL

MONITOR
113
64
188
109
blue turtles
count turtles with [color = blue]
17
1
11

MONITOR
113
20
188
65
red turtles
count turtles with [color = red]
17
1
11

CHOOSER
630
26
722
71
troop-type
troop-type
"muskets" "pawns" "kamikazis" "ninjas" "knights" "mages" "snipers" "berserkers" "medics"
0

BUTTON
193
17
293
50
NIL
place-red
T
1
T
OBSERVER
NIL
NIL
NIL
NIL
1

BUTTON
293
17
399
50
NIL
place-blue
T
1
T
OBSERVER
NIL
NIL
NIL
NIL
1

BUTTON
408
62
605
95
NIL
place-terrain-formation
NIL
1
T
OBSERVER
NIL
NIL
NIL
NIL
1

BUTTON
193
50
400
83
NIL
place-troop-formation-red
NIL
1
T
OBSERVER
NIL
NIL
NIL
NIL
1

BUTTON
408
29
605
62
NIL
place-terrain
T
1
T
OBSERVER
NIL
NIL
NIL
NIL
1

CHOOSER
721
26
813
71
terrain-type
terrain-type
"wall" "trench" "grass"
1

CHOOSER
614
71
722
116
troop-formation
troop-formation
"basic" "british army" "total mayhem" "one v one"
1

CHOOSER
721
71
840
116
terrain-formation
terrain-formation
"grassy field" "western front"
1

BUTTON
193
83
400
116
NIL
place-troop-formation-blue
NIL
1
T
OBSERVER
NIL
NIL
NIL
NIL
1

SWITCH
23
115
167
148
show-health
show-health
0
1
-1000

BUTTON
44
70
107
103
NIL
go
T
1
T
OBSERVER
NIL
NIL
NIL
NIL
1

@#$#@#$#@
## WHAT IS IT?

This is a “game” similar to “Epic Battle Simulator”. The original game allows you to simulate a battle between two different armies, red and blue, where you are given a select amount of money, and you need to use the money to take down pre-made formations that the programmers designed. Ours will be more free range, giving the user the ability to create both sides of the battle. The user will be able to place down their own troops on two different sides, and then watch an animation of the troops as they fight each other. There are a variety of different troop types, and various different pieces of terrain that the troops must be able to navigate.

## HOW IT WORKS

To place multiple troops per click, run the place-red and place-blue at the same time.

## HOW TO USE IT

(how to use the model, including a description of each of the items in the Interface tab)

## Stats for Troops

Specific Values TBD. They are not in the project yet, but the stats there are supposed to be are: Health, AttackDamage, AttackSpeed, MovementSpeed, Range. Some troops will also have another special property unique to them.

## Explanation for Terrain

There are different colors of patches to represent different types of terrain.

Green patches represent tall grass. These slow down units.

Brown patches represent trenches. These are to be used as shelter to ambush other units

Orange patches represent walls. These serve as obstacles that the turtles must destroy.

## CREDITS AND REFERENCES

(a reference to the model's URL on the web if it has one, as well as any other necessary credits, citations, and links)
@#$#@#$#@
default
true
0
Polygon -7500403 true true 150 5 40 250 150 205 260 250

airplane
true
0
Polygon -7500403 true true 150 0 135 15 120 60 120 105 15 165 15 195 120 180 135 240 105 270 120 285 150 270 180 285 210 270 165 240 180 180 285 195 285 165 180 105 180 60 165 15

arrow
true
0
Polygon -7500403 true true 150 0 0 150 105 150 105 293 195 293 195 150 300 150

box
false
0
Polygon -7500403 true true 150 285 285 225 285 75 150 135
Polygon -7500403 true true 150 135 15 75 150 15 285 75
Polygon -7500403 true true 15 75 15 225 150 285 150 135
Line -16777216 false 150 285 150 135
Line -16777216 false 150 135 15 75
Line -16777216 false 150 135 285 75

bug
true
0
Circle -7500403 true true 96 182 108
Circle -7500403 true true 110 127 80
Circle -7500403 true true 110 75 80
Line -7500403 true 150 100 80 30
Line -7500403 true 150 100 220 30

butterfly
true
0
Polygon -7500403 true true 150 165 209 199 225 225 225 255 195 270 165 255 150 240
Polygon -7500403 true true 150 165 89 198 75 225 75 255 105 270 135 255 150 240
Polygon -7500403 true true 139 148 100 105 55 90 25 90 10 105 10 135 25 180 40 195 85 194 139 163
Polygon -7500403 true true 162 150 200 105 245 90 275 90 290 105 290 135 275 180 260 195 215 195 162 165
Polygon -16777216 true false 150 255 135 225 120 150 135 120 150 105 165 120 180 150 165 225
Circle -16777216 true false 135 90 30
Line -16777216 false 150 105 195 60
Line -16777216 false 150 105 105 60

car
false
0
Polygon -7500403 true true 300 180 279 164 261 144 240 135 226 132 213 106 203 84 185 63 159 50 135 50 75 60 0 150 0 165 0 225 300 225 300 180
Circle -16777216 true false 180 180 90
Circle -16777216 true false 30 180 90
Polygon -16777216 true false 162 80 132 78 134 135 209 135 194 105 189 96 180 89
Circle -7500403 true true 47 195 58
Circle -7500403 true true 195 195 58

circle
false
0
Circle -7500403 true true 0 0 300

circle 2
false
0
Circle -7500403 true true 0 0 300
Circle -16777216 true false 30 30 240

cow
false
0
Polygon -7500403 true true 200 193 197 249 179 249 177 196 166 187 140 189 93 191 78 179 72 211 49 209 48 181 37 149 25 120 25 89 45 72 103 84 179 75 198 76 252 64 272 81 293 103 285 121 255 121 242 118 224 167
Polygon -7500403 true true 73 210 86 251 62 249 48 208
Polygon -7500403 true true 25 114 16 195 9 204 23 213 25 200 39 123

cylinder
false
0
Circle -7500403 true true 0 0 300

dot
false
0
Circle -7500403 true true 90 90 120

face happy
false
0
Circle -7500403 true true 8 8 285
Circle -16777216 true false 60 75 60
Circle -16777216 true false 180 75 60
Polygon -16777216 true false 150 255 90 239 62 213 47 191 67 179 90 203 109 218 150 225 192 218 210 203 227 181 251 194 236 217 212 240

face neutral
false
0
Circle -7500403 true true 8 7 285
Circle -16777216 true false 60 75 60
Circle -16777216 true false 180 75 60
Rectangle -16777216 true false 60 195 240 225

face sad
false
0
Circle -7500403 true true 8 8 285
Circle -16777216 true false 60 75 60
Circle -16777216 true false 180 75 60
Polygon -16777216 true false 150 168 90 184 62 210 47 232 67 244 90 220 109 205 150 198 192 205 210 220 227 242 251 229 236 206 212 183

fish
false
0
Polygon -1 true false 44 131 21 87 15 86 0 120 15 150 0 180 13 214 20 212 45 166
Polygon -1 true false 135 195 119 235 95 218 76 210 46 204 60 165
Polygon -1 true false 75 45 83 77 71 103 86 114 166 78 135 60
Polygon -7500403 true true 30 136 151 77 226 81 280 119 292 146 292 160 287 170 270 195 195 210 151 212 30 166
Circle -16777216 true false 215 106 30

flag
false
0
Rectangle -7500403 true true 60 15 75 300
Polygon -7500403 true true 90 150 270 90 90 30
Line -7500403 true 75 135 90 135
Line -7500403 true 75 45 90 45

flower
false
0
Polygon -10899396 true false 135 120 165 165 180 210 180 240 150 300 165 300 195 240 195 195 165 135
Circle -7500403 true true 85 132 38
Circle -7500403 true true 130 147 38
Circle -7500403 true true 192 85 38
Circle -7500403 true true 85 40 38
Circle -7500403 true true 177 40 38
Circle -7500403 true true 177 132 38
Circle -7500403 true true 70 85 38
Circle -7500403 true true 130 25 38
Circle -7500403 true true 96 51 108
Circle -16777216 true false 113 68 74
Polygon -10899396 true false 189 233 219 188 249 173 279 188 234 218
Polygon -10899396 true false 180 255 150 210 105 210 75 240 135 240

house
false
0
Rectangle -7500403 true true 45 120 255 285
Rectangle -16777216 true false 120 210 180 285
Polygon -7500403 true true 15 120 150 15 285 120
Line -16777216 false 30 120 270 120

leaf
false
0
Polygon -7500403 true true 150 210 135 195 120 210 60 210 30 195 60 180 60 165 15 135 30 120 15 105 40 104 45 90 60 90 90 105 105 120 120 120 105 60 120 60 135 30 150 15 165 30 180 60 195 60 180 120 195 120 210 105 240 90 255 90 263 104 285 105 270 120 285 135 240 165 240 180 270 195 240 210 180 210 165 195
Polygon -7500403 true true 135 195 135 240 120 255 105 255 105 285 135 285 165 240 165 195

line
true
0
Line -7500403 true 150 0 150 300

line half
true
0
Line -7500403 true 150 0 150 150

pentagon
false
0
Polygon -7500403 true true 150 15 15 120 60 285 240 285 285 120

person
false
0
Circle -7500403 true true 110 5 80
Polygon -7500403 true true 105 90 120 195 90 285 105 300 135 300 150 225 165 300 195 300 210 285 180 195 195 90
Rectangle -7500403 true true 127 79 172 94
Polygon -7500403 true true 195 90 240 150 225 180 165 105
Polygon -7500403 true true 105 90 60 150 75 180 135 105

plant
false
0
Rectangle -7500403 true true 135 90 165 300
Polygon -7500403 true true 135 255 90 210 45 195 75 255 135 285
Polygon -7500403 true true 165 255 210 210 255 195 225 255 165 285
Polygon -7500403 true true 135 180 90 135 45 120 75 180 135 210
Polygon -7500403 true true 165 180 165 210 225 180 255 120 210 135
Polygon -7500403 true true 135 105 90 60 45 45 75 105 135 135
Polygon -7500403 true true 165 105 165 135 225 105 255 45 210 60
Polygon -7500403 true true 135 90 120 45 150 15 180 45 165 90

sheep
false
15
Circle -1 true true 203 65 88
Circle -1 true true 70 65 162
Circle -1 true true 150 105 120
Polygon -7500403 true false 218 120 240 165 255 165 278 120
Circle -7500403 true false 214 72 67
Rectangle -1 true true 164 223 179 298
Polygon -1 true true 45 285 30 285 30 240 15 195 45 210
Circle -1 true true 3 83 150
Rectangle -1 true true 65 221 80 296
Polygon -1 true true 195 285 210 285 210 240 240 210 195 210
Polygon -7500403 true false 276 85 285 105 302 99 294 83
Polygon -7500403 true false 219 85 210 105 193 99 201 83

square
false
0
Rectangle -7500403 true true 30 30 270 270

square 2
false
0
Rectangle -7500403 true true 30 30 270 270
Rectangle -16777216 true false 60 60 240 240

star
false
0
Polygon -7500403 true true 151 1 185 108 298 108 207 175 242 282 151 216 59 282 94 175 3 108 116 108

target
false
0
Circle -7500403 true true 0 0 300
Circle -16777216 true false 30 30 240
Circle -7500403 true true 60 60 180
Circle -16777216 true false 90 90 120
Circle -7500403 true true 120 120 60

tree
false
0
Circle -7500403 true true 118 3 94
Rectangle -6459832 true false 120 195 180 300
Circle -7500403 true true 65 21 108
Circle -7500403 true true 116 41 127
Circle -7500403 true true 45 90 120
Circle -7500403 true true 104 74 152

triangle
false
0
Polygon -7500403 true true 150 30 15 255 285 255

triangle 2
false
0
Polygon -7500403 true true 150 30 15 255 285 255
Polygon -16777216 true false 151 99 225 223 75 224

truck
false
0
Rectangle -7500403 true true 4 45 195 187
Polygon -7500403 true true 296 193 296 150 259 134 244 104 208 104 207 194
Rectangle -1 true false 195 60 195 105
Polygon -16777216 true false 238 112 252 141 219 141 218 112
Circle -16777216 true false 234 174 42
Rectangle -7500403 true true 181 185 214 194
Circle -16777216 true false 144 174 42
Circle -16777216 true false 24 174 42
Circle -7500403 false true 24 174 42
Circle -7500403 false true 144 174 42
Circle -7500403 false true 234 174 42

turtle
true
0
Polygon -10899396 true false 215 204 240 233 246 254 228 266 215 252 193 210
Polygon -10899396 true false 195 90 225 75 245 75 260 89 269 108 261 124 240 105 225 105 210 105
Polygon -10899396 true false 105 90 75 75 55 75 40 89 31 108 39 124 60 105 75 105 90 105
Polygon -10899396 true false 132 85 134 64 107 51 108 17 150 2 192 18 192 52 169 65 172 87
Polygon -10899396 true false 85 204 60 233 54 254 72 266 85 252 107 210
Polygon -7500403 true true 119 75 179 75 209 101 224 135 220 225 175 261 128 261 81 224 74 135 88 99

wheel
false
0
Circle -7500403 true true 3 3 294
Circle -16777216 true false 30 30 240
Line -7500403 true 150 285 150 15
Line -7500403 true 15 150 285 150
Circle -7500403 true true 120 120 60
Line -7500403 true 216 40 79 269
Line -7500403 true 40 84 269 221
Line -7500403 true 40 216 269 79
Line -7500403 true 84 40 221 269

wolf
false
0
Polygon -16777216 true false 253 133 245 131 245 133
Polygon -7500403 true true 2 194 13 197 30 191 38 193 38 205 20 226 20 257 27 265 38 266 40 260 31 253 31 230 60 206 68 198 75 209 66 228 65 243 82 261 84 268 100 267 103 261 77 239 79 231 100 207 98 196 119 201 143 202 160 195 166 210 172 213 173 238 167 251 160 248 154 265 169 264 178 247 186 240 198 260 200 271 217 271 219 262 207 258 195 230 192 198 210 184 227 164 242 144 259 145 284 151 277 141 293 140 299 134 297 127 273 119 270 105
Polygon -7500403 true true -1 195 14 180 36 166 40 153 53 140 82 131 134 133 159 126 188 115 227 108 236 102 238 98 268 86 269 92 281 87 269 103 269 113

x
false
0
Polygon -7500403 true true 270 75 225 30 30 225 75 270
Polygon -7500403 true true 30 75 75 30 270 225 225 270
@#$#@#$#@
NetLogo 6.0.2
@#$#@#$#@
@#$#@#$#@
@#$#@#$#@
@#$#@#$#@
@#$#@#$#@
default
0.0
-0.2 0 0.0 1.0
0.0 1 1.0 0.0
0.2 0 0.0 1.0
link direction
true
0
Line -7500403 true 150 150 90 180
Line -7500403 true 150 150 210 180
@#$#@#$#@
0
@#$#@#$#@
