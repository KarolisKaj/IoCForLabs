using IoCAutoFacAttributes.Interfaces;

namespace IoCAutoFacAttributes.Dependencies
{
    public class PrimaryService : IService
    {
        public void PrintCalendarInfo(ICalendar calendar)
        {
            System.Console.WriteLine(calendar);
        }
    }
}
