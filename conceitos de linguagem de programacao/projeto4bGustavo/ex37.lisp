(defun fibonacci (n)
 (cond
 ((< n 1) nil)
 ((< n 3) 1)
 (T (+ (fibonacci (- n 1)) (fibonacci (- n 2))))
 )
)

(defun produto (n)
 (cond
 ((< n 1) nil)
 ((< n 3) 1)
 (T (* (fibonacci n)(produto (- n 1))))
 )
)

(defun medir-tempo (n)
  (let ((start-time (get-internal-real-time)))
    (produto n)
    (/ (- (get-internal-real-time) start-time) internal-time-units-per-second)))

(defun encontrar-max-n (max-tempo)
  (loop for n from 1
        while (< (medir-tempo n) max-tempo)
        finally (return (1- n))))

;; Testando para encontrar o valor máximo de n em menos de 1 minuto
(format t "Máximo n para calcular produto em menos de 1 minuto: ~d~%" (encontrar-max-n 60))