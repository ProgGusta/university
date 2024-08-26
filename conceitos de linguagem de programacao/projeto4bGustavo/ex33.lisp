(defun raiz (a n)
 (cond
 ((< n 0) nil)
 ((zerop n) 1)
 (T (/ (+ (raiz a (- n 1)) (/ 3 (raiz a (- n 1)))) 2))
 )
)

(defun precisa (a n tol)
  (let ((valor (raiz a n))
        (valor-mais-1 (raiz a (+ n 1))))
    (if (< (abs (- valor valor-mais-1)) tol)
        n
        (precisa a (+ n 1) tol))))

(defun determinar-n (a)
  (precisa a 0 1e-15))

;; Testando para diferentes valores de a
(format t "n para sqrt(2): ~d~%" (determinar-n 2))
(format t "n para sqrt(3): ~d~%" (determinar-n 3))
(format t "n para sqrt(10): ~d~%" (determinar-n 15))