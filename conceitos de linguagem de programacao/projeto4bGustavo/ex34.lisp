(defun seriePI (n)
 (cond
 ((< n 1) nil)
 ((eql n 1) 4)
 ((eql (mod n 2) 0) (- (seriePI (- n 1))(/ 4 (- (* n 2) 1))))
 (T (+ (seriePI (- n 1))(/ 4 (- (* n 2) 1))))
 )
)

(defun precisa (n tol)
  (let* ((pi-aprox (seriePI n))
         (pi-aprox-mais-1 (seriePI (+ n 1)))
         (pi-real (* 4.0 (atan 1.0))))
    (if (< (abs (- pi-aprox pi-real)) tol)
        n
        (precisa (+ n 1) tol))))

(defun determinar-n ()
  (precisa 1 1e-15))

;; Testando para determinar n
(format t "n para aproximar PI com precisão: ~d~%" (determinar-n))