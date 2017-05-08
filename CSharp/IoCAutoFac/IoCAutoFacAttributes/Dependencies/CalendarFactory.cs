using IoCAutoFacAttributes.Interfaces;

namespace IoCAutoFacAttributes.Dependencies
{
    public class CalendarFactory : ICalendarFactory
    {
        public IService DefaultService { get; set; }
        public CalendarFactory(IService service)
        {
            DefaultService = service;
        }

        public CalendarFactory()
        {
            DefaultService = null;
        }

        public ICalendar GetCalendar() => DefaultService == null ? (ICalendar)new EuropeanCalendar() : (ICalendar)new GenericCalendar();
    }
}
