(defun insertion-sort (list)
  (if (null list)
      nil
      (insert (car list) (insertion-sort (cdr list)))))

(defun insert (x sorted-list)
  (cond ((null sorted-list) (list x))
        ((< x (car sorted-list)) (cons x sorted-list))
        (t (cons (car sorted-list) (insert x (cdr sorted-list))))))



(defun bubble-sort (list)
  (if (null list)
      nil
      (bubble-sort-pass list)))

(defun bubble-sort-pass (list)
  (let ((pass-result (bubble-pass list)))
    (if (null (cdr pass-result))
        (car pass-result)
        (append (bubble-sort-pass (butlast pass-result)) (list (last pass-result))))))

(defun bubble-pass (list)
  (if (or (null list) (null (cdr list)))
      list
      (let ((a (car list))
            (b (cadr list)))
        (if (> a b)
            (cons b (bubble-pass (cons a (cddr list))))
            (cons a (bubble-pass (cdr list)))))))




(defun merge-sort (list)
  (if (or (null list) (null (cdr list)))
      list
      (let ((middle (floor (length list) 2)))
        (merge (merge-sort (subseq list 0 middle))
               (merge-sort (subseq list middle))))))

(defun merge (left right)
  (cond ((null left) right)
        ((null right) left)
        ((<= (car left) (car right)) (cons (car left) (merge (cdr left) right)))
        (t (cons (car right) (merge left (cdr right))))))



(defun quicksort (list)
  (if (or (null list) (null (cdr list)))
      list
      (let* ((pivot (car list))
             (rest (cdr list))
             (lesser (remove-if-not (lambda (x) (<= x pivot)) rest))
             (greater (remove-if-not (lambda (x) (> x pivot)) rest)))
        (append (quicksort lesser) (list pivot) (quicksort greater)))))
