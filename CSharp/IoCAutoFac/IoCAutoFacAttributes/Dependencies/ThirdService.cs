using IoCAutoFacAttributes.Interfaces;

namespace IoCAutoFacAttributes.Dependencies
{
    public class ThirdService : IService
    {
        private readonly ICalendar _calendar;

        public ThirdService(ICalendarFactory factory)
        {
            _calendar = factory.GetCalendar();
        }
    }
}
