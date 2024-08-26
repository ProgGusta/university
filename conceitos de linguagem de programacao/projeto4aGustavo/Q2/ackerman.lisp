(defun ackerman (m n)
  (cond ((= m 0) (+ n 1))
        ((= n 0) (ackerman (- m 1) 1))
        (t (ackerman (- m 1) (ackerman m (- n 1))))))

(defun measure-time (m n)
  (let ((start (get-internal-real-time)))
    (ackerman m n)
    (/ (- (get-internal-real-time) start) internal-time-units-per-second)))

(with-open-file (stream "lisp_ackerman_times.csv"
                        :direction :output
                        :if-exists :supersede
                        :external-format :utf-8)
  (format stream "m,n,time~%")
  (loop for m from 0 to 3 do
        (loop for n from 0 to 3 do
              (format stream "~d,~d,~f~%" m n (measure-time m n)))))