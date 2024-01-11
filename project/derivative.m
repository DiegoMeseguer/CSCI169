%% Differentiation using the Symbolic Math Toolbox

% Compute some values of d/dx(ln(2)) using central difference formula
[resultApprox, h] = diff_approx_ln(2);

% Create error table to compare with the built-in Matlab function
error = absolute_error(resultApprox);
 
% Create final table
myTable = table(h, resultApprox, error);
myTable.Properties.VariableNames = ["h", "Difference Approximation", "Error"];
myTable

%%%% FUNCTION DEFINITIONS %%%%

% Implements central diff formula for ln(x)
function [fPrime, hValues] = diff_approx_ln(x)
    
    syms h
    h = 0.1;
    fPrime = zeros(6, 1);
    hValues = zeros(6, 1);

    for i = 1:6
        hValues(i) = h;
        fPrime(i) = (log(x + h) - log(x - h)) ./ (2 * h);
        h = h ./ 10;
    end
end

% Generates the error table
function out = absolute_error(array)

    syms x
    out = zeros(size(array));
    lnx = diff(log(x)); % use Matlab built-in diff func
    
    for i = 1:length(array)
        out(i) = abs(array(i) - subs(lnx, x, 2));
    end
end
