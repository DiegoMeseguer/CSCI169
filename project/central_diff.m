%% Obtaining the Central Difference Formula using the Symbolic Math Toolbox

% define some symbolic variables and functions
syms f(x) x0 h

tPoly = taylor(f(x), x, x0, 'Order', 3);

fPlu = subs(tPoly, x, x0 + h);
fMin = subs(tPoly, x, x0 - h);

% Get the two equations
fPlus = f(x0 + h) == fPlu;
fMinus = f(x0 - h) == fMin;

% Subtract the Taylor Series
addTaylor = fPlus - fMinus;

% Solve for d/dx(f(x0))
centralEqn = isolate(addTaylor, diff(f(x0)));

% We only want the right hande side of the equation
centralDifference = rhs(centralEqn);

% Show result
pretty(centralDifference)

