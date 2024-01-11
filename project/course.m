% Course class definition

classdef course
    properties (SetAccess = private)
        Name (1, 1) string
        Level (1, 1) string {mustBeMember(Level, ["White","Yellow","Green","Orange","Red"])} = "White"
        Waypoints (:, 1) double {mustBeNumeric, mustBePositive, mustBeInteger}
    end

    methods
        % Constructor
        function obj = course(name, level, waypoints)
            arguments
                name {mustBeText} = "Empty"
                level = "White"
                waypoints {mustBeNumeric} = [1;2;3]
            end
            if nargin == 3 || nargin == 0
                obj.Name = name;
                obj.Level = level;
                obj.Waypoints = waypoints;
            end
        end

        function ok = checkWaypoint(course, id, wayptidx)
            % Get the index of the previous waypoint found
            [~,prevwpidx] = max(id.Timestamps);
            % Current waypoint should be the next one
            ok = (wayptidx == (1+prevwpidx));
        end

        function disp(c)
            function single(c)
                strFirst = c.Level + " course " + c.Name + ...
                        " with " + numel(c.Waypoints) + ...
                        " waypoints";
                strLast = join(string(c.Waypoints),"   ");
                out = strFirst + newline + strLast;
                disp(out);
            end
            if nargin == 1
                for k = 1:numel(c)
                    single(c(k))
                end
            end
        end
    end

end

