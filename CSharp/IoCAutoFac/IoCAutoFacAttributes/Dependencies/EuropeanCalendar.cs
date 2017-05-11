using IoCAutoFacAttributes.Interfaces;

namespace IoCAutoFacAttributes.Dependencies
{
    public class EuropeanCalendar : ICalendar
    {
        private IService Service { get; set; }
        public EuropeanCalendar(ServiceFactory factory)
        {
            factory.Name = "EuropeanCalendar Service";
            Service = factory.GetObject;
        }
    }
}
