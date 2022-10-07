class MyCalendarThree {

    private class Event implements Comparable<Event> {
        public int start, end, bookingCnt;

        public Event(int start, int end, int bookingCnt) {
            this.start = start;
            this.end = end;
            this.bookingCnt = bookingCnt;
        }

        @Override
        public int compareTo(Event o) {
            if(this.start == o.start) return this.end - o.end;
            else return this.start - o.start;
        }
    }

    int maxBookingCnt;
    PriorityQueue<Event> events;

    public MyCalendarThree() {
        this.events = new PriorityQueue<>();
        this.maxBookingCnt = 0;
    }

    private void pushToPq(PriorityQueue<Event> pq, Event event) {
        maxBookingCnt = Math.max(event.bookingCnt, maxBookingCnt);
        pq.add(event);
    }

    public int book(int start, int end) {

        PriorityQueue<Event> newEvents = new PriorityQueue<>();

        while (!events.isEmpty()) {
            Event curEvent = events.poll();

            // 겹치는 부분이 없는 경우
            if(curEvent.end <= start || curEvent.start >= end) {
                pushToPq(newEvents, curEvent);
                continue;
            }

            if (curEvent.start > start) {
                pushToPq(newEvents, new Event(start, curEvent.start, 1));
                start = curEvent.start;
            }

            if (curEvent.start < start) {
                pushToPq(newEvents, new Event(curEvent.start, start, curEvent.bookingCnt));
                curEvent.start = start;
            }

            if (curEvent.end > end) {
                pushToPq(newEvents, new Event(start, end, curEvent.bookingCnt + 1));
                pushToPq(newEvents, new Event(end, curEvent.end, curEvent.bookingCnt));
                start = end;
            }

            if (curEvent.end == end) {
                pushToPq(newEvents, new Event(start, end, curEvent.bookingCnt + 1));
                start = end;
            }

            if (curEvent.end < end) {
                pushToPq(newEvents, new Event(curEvent.start, curEvent.end, curEvent.bookingCnt + 1));
                start = curEvent.end;
            }
        }
        if(start != end) {
            pushToPq(newEvents, new Event(start, end, 1));
        }

        events = newEvents;
        return maxBookingCnt;
    }
}