chessboardSize = 8;

% Create even array
pares = [];
for i = 1:chessboardSize
    if mod(i,2) == 0
        pares(length(pares) + 1) = i;
    end
end

% Create odd array
impares = [];
for i = 1:chessboardSize
    if mod(i,2) ~= 0
        impares(length(impares) + 1) = i;
    end
end

% Swap 1 and 3 in the odd list
temp = impares(1);
impares(1) = impares(2);
impares(2) = temp;

% Move 5 to the end of the odd list
temp = impares(3);
impares(3) = [];
impares(length(impares) + 1) = temp;

% Combine the two lists
solutions = [pares, impares];

% Print the board
for row = chessboardSize:-1:1       % From 8 to 1
    for column = 1:chessboardSize   % From a to h
        if row == solutions(column)
            fprintf("1 ");
        else
            fprintf("0 ");
        end
    end
    fprintf("\n");
end



