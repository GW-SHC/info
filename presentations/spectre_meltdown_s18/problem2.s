.data
TWO: .double 2.0
Y: .double 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
X: .double 0, 0, 0, 0, 0, 0, 0, 0, 0

.text
; Init code
L.D F0, TWO(R0)
DADDUI R1, R0, Y  ; get it to the start
DADDUI R1, R1, 72 ; add 72 (8*9) to bring the memory reference to the end of the array-1 since first element accessed is y[k+1]
DADDUI R2, R0, X
DADDUI R2, R2, 72
DADDUI R20, R0, Y ; store original reference to determine if branching should occur

Loop: 
L.D F2, 8(R1) ; y[k+1]
L.D F4, 0(R1) ; y[k]
MUL.D F6, F4, F0
SUB.D F8, F2, F6
S.D F8, 0(R2) ; x[k]
DADDUI R1, R1, -8
DADDUI R2, R2, -8
BNE R20, R1, Loop ; keep branching as long as we havent hit the end of the array
halt