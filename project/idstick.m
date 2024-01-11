% ID Stick class definition

classdef idstick
    properties (Access = private)
        Status (1, 1) string
    end
    properties (SetAccess = immutable)
        SerialNumber (1, 1) uint32
    end
    properties (SetAccess = private)
        Participant (1, 1) string
        Course (1, 1) course
        Timestamps (:, 1) datetime
    end

    methods
        % Constructor
        function obj = idstick(snum)
            arguments
                snum {mustBeNumeric, mustBePositive, mustBeInteger} = 123
            end
            if (nargin == 1) || (nargin == 0)
                for k = 1:numel(snum)
                    obj(k).SerialNumber = snum(k);
                end
            end
        end
        
        function disp(id)
            function single(id)
                % Start building display string
                str = "ID stick #" + id.SerialNumber;
                % Add participant info, if applicable
                if id.Participant == ""
                    str = str + " which is not yet registered";
                    disp(str)
                else
                    str = str + " is registered to " + id.Participant + " who is ";
                    % Use status to get the correct wording
                    switch id.Status
                        case "Ready"
                            str = str + "ready to run";
                        case "Running"
                            str = str + "running";
                        case "Done"
                            str = str + "finished with";
                    end
                    % Display the string, then display the course details
                    disp(str)
                    disp(id.Course)
                end
            end
            if nargin == 1
                for k = 1:numel(id)
                    single(id(k));
                end
            end
        end

        
        function obj = register(id, name, course)
            function obj = single(id, name, course)
                id.Participant = name;
                id.Course = course;
                id.Timestamps = NaT(size(course.Waypoints));
                id.Status = "Ready";
                signal(id, true);
                obj = id;
            end
            if (nargin == 3) && ((numel(id) == numel(name)) && (numel(name) == numel(course))) 
               for k = 1:numel(id)
                   obj(k) = single(id(k), name(k), course(k));
               end
            end
        end

        function id = checkWaypoint(id, wayptnum)
            % Get the course object
            c = id.Course;
            % Check and update ID stick status
            % Check that this waypoint is on this course
            [id,ok,n] = updateStatus(id,wayptnum);
            % If the waypoint is valid, the ID stick status is ok, and the
            % waypoint is not the start, use the course method to check
            % this waypoint according to the rules of the course. (If this
            % waypoint is the start, there's nothing more to check.)
            if ok && (n > 1)
                ok = checkWaypoint(c,id,n);
            end
            % Update the time stamp of this waypoint
            id.Timestamps(n) = datetime("now");
            % Tell the participant what happened
            signal(id,ok)
        end
    end

    methods (Access = private)
        function signal(id, ok)
            if ok
                if (id.Status == "Ready") || (id.Status == "Done")
                    disp("Beep beep");
                else
                    disp("Beep");
                end
            else
                disp("Buzz");
            end
        end

        function [id, ok, idx] = updateStatus(id, wayptnum)
            % Find the given waypoint in the list for this course
            wplist = id.Course.Waypoints;
            idx = find(wayptnum == wplist,1,"first");
            % What is the current ID Stick status?
            if (id.Status == "Error") || (id.Status == "Done")
                % Leave status alone, this check-in is a fail
                ok = false;
            elseif (id.Status == "Ready")
                % Ready to start. Check that this waypoint is the start
                if (idx == 1)
                    % Alright, let's go!
                    id.Status = "Running";
                    ok = true;
                else
                    % Checking in at a later waypoint before starting
                    ok = false;
                end
            else
                % In progress. Check that this waypoint is on this course
                ok = ~isempty(idx);
                % If this waypoint is the end, we're done
                if (idx == numel(wplist))
                    id.Status = "Done";
                end
            end
        end
    end
    
end

