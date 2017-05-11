using IoCAutoFacAttributes.Interfaces;

namespace IoCAutoFacAttributes.Dependencies
{
    public class StaticCalendar : ICalendar
    {
        public static ICalendar CreateInstance() => new StaticCalendar();
    }
}
