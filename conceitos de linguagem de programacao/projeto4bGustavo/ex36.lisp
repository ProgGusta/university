(defun fatorial (n)
 (cond
 ((< n 0) nil)
 ((zerop n) 1)
 (T (* n (fatorial (- n 1))))
 )
)

(defun fibonacci (n)
 (cond
 ((< n 1) nil)
 ((< n 3) 1)
 (T (+ (fibonacci (- n 1)) (fibonacci (- n 2))))
 )
)

(defun serieG (n)
 (cond
 ((< n 1) nil)
 ((eql n 1) 1)
 ((eql (mod n 2) 0) (- (serieG (- n 1))(/ n (fatorial (fibonacci n)))))
 (T (+ (serieG (- n 1))(/ n (fatorial (fibonacci n)))))
 )
)

(defun medir-tempo (n)
  (let ((start-time (get-internal-real-time)))
    (serieG n)
    (/ (- (get-internal-real-time) start-time) internal-time-units-per-second)))

(defun encontrar-max-n (max-tempo)
  (loop for n from 1
        while (< (medir-tempo n) max-tempo)
        finally (return (1- n))))

;; Testando para encontrar o valor máximo de n em menos de 1 minuto
(format t "Máximo n para calcular serieG em menos de 1 minuto: ~d~%" (encontrar-max-n 60))