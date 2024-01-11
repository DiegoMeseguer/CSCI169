
myList = [1, 3, 6, 10, 14, 23, 25, 28, 30, 31, 37];
answer = binary_search(myList, 25);
disp(myList(answer));
% Code for Binary Search
function out = binary_search(lista, target)
    left = 0;
    right = length(lista) - 1;
    while left <= right
        middle = floor((left + right) / 2);
        if lista(middle) == target
            out = middle;
            return
        elseif lista(middle) > target
            right = middle - 1;
        elseif lista(middle) < target
            left = middle + 1;
        end
    end
    out = -1;
end
