(defun fatorial (n)
 (cond
 ((< n 0) nil)
 ((zerop n) 1)
 (T (* n (fatorial (- n 1))))
 )
)

(defun potencia (b e)
 (cond
 ((< e 0) nil)
 ((zerop e) 1)
 (T (* b (potencia b (- e 1))))
 )
)

(defun serieH (n)
 (cond
 ((< n 1) nil)
 ((eql n 1) 1)
 ((eql (mod n 2) 0) (- (serieH (- n 1))(/ (potencia n n) (fatorial n))))
 (T (+ (serieH (- n 1))(/ (potencia n n)(fatorial n))))
 )
)

(defun medir-tempo (n)
  (let ((start-time (get-internal-real-time)))
    (serieH n)
    (/ (- (get-internal-real-time) start-time) internal-time-units-per-second)))

(defun encontrar-max-n (max-tempo)
  (loop for n from 1
        while (< (medir-tempo n) max-tempo)
        finally (return (1- n))))

;; Testando para encontrar o valor máximo de n em menos de 1 minuto
(format t "Máximo n para calcular serieH em menos de 1 minuto: ~d~%" (encontrar-max-n 60))