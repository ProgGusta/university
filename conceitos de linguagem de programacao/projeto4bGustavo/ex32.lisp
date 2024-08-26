;exercicio 32
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
(defun ex (x n)
 (cond
 ((< n 0) nil)
 ((zerop n) 1)
 (T (+ (/ (potencia x n) (fatorial n)) (ex x (- n 1))))
 )
)

(defun precisa (x n tol)
  (let ((valor (ex x n))
        (valor-mais-1 (ex x (+ n 1))))
    (if (< (abs (- valor valor-mais-1)) tol)
        n
        (precisa x (+ n 1) tol))))

(defun determinar-n (x)
  (precisa x 0 1e-15))

;; Testando para diferentes valores de x
(format t "n para e^1: ~d~%" (determinar-n 1))
(format t "n para e^2: ~d~%" (determinar-n 2))
(format t "n para e^10: ~d~%" (determinar-n 10))
(format t "n para e^5: ~d~%" (determinar-n 5))
(format t "n para e^0.5: ~d~%" (determinar-n 0.5))