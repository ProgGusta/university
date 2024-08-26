(defun generate-list (size)
  (loop repeat size collect (random 10000)))

(defun measure-sort-time (sort-function list)
  (let ((start-time (get-internal-real-time)))
    (funcall sort-function list)
    (/ (- (get-internal-real-time) start-time) internal-time-units-per-second)))

(defun write-results (size times)
  (with-open-file (stream "lisp_sort_times.csv" :direction :output :if-exists :append :if-does-not-exist :create)
    (format stream "~a,~a,~a,~a,~a~%" size (nth 0 times) (nth 1 times) (nth 2 times) (nth 3 times))))

(defun insertion-sort (list)
  (loop for i from 1 below (length list)
        for key = (nth i list)
        for j = (- i 1)
        while (and (>= j 0) (> (nth j list) key)) do
          (setf (nth (+ j 1) list) (nth j list))
          (decf j)
        finally (setf (nth (+ j 1) list) key)))

(defun bubble-sort (list)
  (loop for i from 0 below (length list)
        do (loop for j from 0 below (- (length list) i 1)
                 if (> (nth j list) (nth (+ j 1) list))
                 do (rotatef (nth j list) (nth (+ j 1) list)))))

(defun merge-sort (list)
  (if (<= (length list) 1)
      list
      (let* ((mid (ash (length list) -1))
             (left (subseq list 0 mid))
             (right (subseq list mid)))
        (merge 'list (merge-sort left) (merge-sort right) #'<))))

(defun quicksort (list)
  (if (<= (length list) 1)
      list
      (let ((pivot (car list)))
        (append (quicksort (remove-if-not (lambda (x) (< x pivot)) (cdr list)))
                (list pivot)
                (quicksort (remove-if-not (lambda (x) (>= x pivot)) (cdr list)))))))

(defun main ()
  (dolist (size '(10 100 1000 10000))
    (let ((list (generate-list size)))
      (write-results size (list
        (measure-sort-time #'insertion-sort (copy-list list))
        (measure-sort-time #'bubble-sort (copy-list list))
        (measure-sort-time #'merge-sort (copy-list list))
        (measure-sort-time #'quicksort (copy-list list)))))))

(main)